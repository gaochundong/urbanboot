package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.converter;

import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.contract.pojo.TrafficLight;
import fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.entity.TrafficLightPO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-27T22:45:45+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class TrafficLightConverterImpl implements TrafficLightConverter {

    @Override
    public List<TrafficLight> convertTrafficLightList(List<TrafficLightPO> from) {
        if ( from == null ) {
            return null;
        }

        List<TrafficLight> list = new ArrayList<TrafficLight>( from.size() );
        for ( TrafficLightPO trafficLightPO : from ) {
            list.add( convertTrafficLight( trafficLightPO ) );
        }

        return list;
    }

    @Override
    public TrafficLight convertTrafficLight(TrafficLightPO from) {
        if ( from == null ) {
            return null;
        }

        TrafficLight trafficLight = new TrafficLight();

        trafficLight.setId( convertUUID( from.getId() ) );
        trafficLight.setName( from.getName() );

        return trafficLight;
    }
}
