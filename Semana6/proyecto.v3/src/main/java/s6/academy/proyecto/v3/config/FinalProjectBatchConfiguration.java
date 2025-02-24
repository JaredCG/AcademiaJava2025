package s6.academy.proyecto.v3.config;
/*ItemReader e ItemWriter de Spring Batch
 * Componente de Job/Step para leer los datos en este caso de un csv
 * 
 * 
 * 
 * */
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import s6.academy.proyecto.v3.MusicProcessor;
import s6.academy.proyecto.v3.bo.Cancion;

@Configuration
public class FinalProjectBatchConfiguration {
	
	@Value("${file.input}")
    private String fileInput;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader reader() {
        return new FlatFileItemReaderBuilder<>()
            .name("espressoReader")
            .resource(new ClassPathResource(fileInput))
            .linesToSkip(1)
            .delimited()
            .names(new String[] { "songId", "titulo", "artista", "album","genero","duracion" })
            .fieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(Cancion.class);
            }})
            .build();
    }
	
	@SuppressWarnings({ "rawtypes" })
    @Bean
    public JdbcBatchItemWriter writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO fonoteca (songId, titulo, artista, album,genero,duracion) VALUES (:songId, :titulo, :artista, :album,:genero,:duracion)")
            .dataSource(dataSource)
            .build();
    }
	
	@Bean
    public Job importUserJob(JobRepository jobRepository, JobExecutionListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(jobCompletionListener())
            .flow(step1)
            .end()
            .build();
    }
	
	@Bean
    public JobExecutionListener jobCompletionListener() {
        return new JobExecutionListener() {//En remplazo de JobExecutionListenerSupport que es Deprecated
		};
    }
	
	@SuppressWarnings("unchecked")
	@Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, @SuppressWarnings("rawtypes") JdbcBatchItemWriter writer) {
        return new StepBuilder("step1", jobRepository)
            .<Cancion, Cancion>chunk(5, transactionManager)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
	
	@Bean
    public MusicProcessor processor() {
        return new MusicProcessor();
    }
}
