package s6.academy.proyecto.v3;
/* ItemProcessor de Spring Batch
 * Componente de Job/Step para procesar y/o transformar los datos 
 * No seguir implementando porque no usaré Spring Batch
 * 
 * */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;

import s6.academy.proyecto.v3.bo.Cancion;

public class MusicProcessor /*implements ItemProcessor<Cancion, Cancion> */{
	
	private Logger LOGGER = LoggerFactory.getLogger(MusicProcessor.class);

//    @Override
//    public Cancion process(final Cancion product) throws Exception {
////        String price = "$" + product.getPrice();
//        
//        Cancion transformedProduct = new Cancion(
////        		product.getProductId(), 
////        		product.getProductName(), 
////        		product.getProductDesc(), 
//        		//price
//        		);
//        
//        LOGGER.info("Converting ( {} ) into ( {} )", product, transformedProduct);
//        return transformedProduct;
//    }

}
