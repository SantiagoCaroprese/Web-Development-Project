
package com.javeriana.web.project.PropertiesTest.PropertyTest;
/*
import com.javeriana.web.project.Properties.Property.Application.Create.PropertyCreator;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Properties.Property.Application.Update.PropertyModifier;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyConditionEnum;
import com.javeriana.web.project.Shared.Domain.Properties.PropertyTypeEnum;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PropertyTest {

    @Test
    void should_create_property(){
        PropertyRepository repository = mock(PropertyRepository.class);
        PropertyCreator creator = new PropertyCreator(repository);
        Property actualProperty = new Property(new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),new Address("calle 100"),new PropertyType(PropertyTypeEnum.APARTAMENTO),new City("bogota"),new Description("es grande"),new BedroomsNumber(3),new BathroomsNumber(2),new PrivateArea(1000),new BuiltArea(100),new ServiceLevel(3), new Condition(PropertyConditionEnum.NUEVO),new DeliveryDate(LocalDate.of(2021,5,11)),new Location((long)1.12345678,(long)1.12345678),null,null,null);
        creator.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721","calle 100",PropertyTypeEnum.APARTAMENTO,"bogota","es grande",3,2,1000,100,3,PropertyConditionEnum.NUEVO, LocalDate.of(2021,5,11),(long)1.12345678,(long)1.12345678,null,null,null);
        verify(repository,atLeastOnce()).save(actualProperty);
    }

    @Test
    void should_find_property(){
        Property actualProperty = new Property(new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),new Address("calle 100"),new PropertyType(PropertyTypeEnum.APARTAMENTO),new City("bogota"),new Description("es grande"),new BedroomsNumber(3),new BathroomsNumber(2),new PrivateArea(1000),new BuiltArea(100),new ServiceLevel(3), new Condition(PropertyConditionEnum.NUEVO),new DeliveryDate(LocalDate.of(2021,5,11)),new Location((long)1.122323,(long)1.12232323),null,null,null);
        PropertyRepository repository = mock(PropertyRepository.class);
        Mockito.when(repository.find("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721")).thenReturn(Optional.of(actualProperty));
        PropertyFinder finder = new PropertyFinder(repository);
        assertEquals(actualProperty,finder.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"));
    }

    @Test
    void should_update_property(){
        Property actualProperty = new Property(new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),new Address("calle 100"),new PropertyType(PropertyTypeEnum.APARTAMENTO),new City("bogota"),new Description("es grande"),new BedroomsNumber(3),new BathroomsNumber(2),new PrivateArea(1000),new BuiltArea(100),new ServiceLevel(3), new Condition(PropertyConditionEnum.NUEVO),new DeliveryDate(LocalDate.of(2021,5,11)),new Location((long)1.12345678,(long)1.12345678),null,null,null);
        Property propertyEdited = new Property(new PropertyId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),new Address("calle 105"),new PropertyType(PropertyTypeEnum.APARTAMENTO),new City("Medellin"),new Description("es grande"),new BedroomsNumber(3),new BathroomsNumber(2),new PrivateArea(1000),new BuiltArea(100),new ServiceLevel(3), new Condition(PropertyConditionEnum.NUEVO),new DeliveryDate(LocalDate.of(2021,5,11)),new Location((long)1.12345678,(long)1.12345678),null,null,null);
        PropertyRepository repository = mock(PropertyRepository.class);
        Mockito.when(repository.find("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721")).thenReturn((Optional.of(actualProperty)));
        PropertyModifier modifier = new PropertyModifier(repository);
        modifier.execute("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721", "calle 105",PropertyTypeEnum.APARTAMENTO,"Medellin","es grande",3,2,1000,100,3, PropertyConditionEnum.NUEVO, LocalDate.of(2021,5,11),(long)1.12345678,(long)1.12345678,null,null,null);
        verify(repository,atLeastOnce()).update("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721", propertyEdited);
    }

    @Test
    void should_filter_properties(){

    }
}
*/