package by.itstep.viarzilin.service;

import by.itstep.viarzilin.domain.Car;
import by.itstep.viarzilin.repository.CarRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    CarService carService;

    @MockBean
    CarRepo carRepo;


    Car carOne;
    Car carTwo;

    @Before
    public void setUp()  {
        carOne = new Car();
        carOne.setMark("VW");
        carOne.setModel("Polo");
        carOne.setColor("red");
        carOne.setVin("1212121212121212e");
        carOne.setDeleted(false);

        carTwo = new Car();
        carTwo.setMark("VW");
        carTwo.setModel("Golf");
        carTwo.setColor("black");
        carTwo.setVin("2212121212121212e");
        carTwo.setDeleted(true);
    }

    @Test
    public void saveCar() {
        Mockito.when(carRepo.findByVin(carOne.getVin())).thenReturn(null);
        boolean carIsSaved = carService.saveCar(carOne);
        Assert.assertTrue(carIsSaved);

    }

    @Test
    public void getAll() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void repareCar() {
    }
}