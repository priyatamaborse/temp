package assignment.com.yash.training;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(value=MockitoJUnitRunner.class)
public class TeaCoffeeVendingMachineOperationImplTest {

	
	@InjectMocks
	private TeaCoffeeVendingMachineOperationImpl teaCoffeeVendingMachineOperationImpl;
	
	@Mock
	private ContainerMaterialDTO containerMaterialDTO;
	
	@Mock
	private MyScanner scanner;
	
	@Mock
	private Appender appenderMock;
	
	@Before
    public void setupAppender() {
		
        appenderMock = mock(Appender.class);
        Logger.getRootLogger().addAppender(appenderMock);
    }
    @After
    public void removeAppender() {
    	
        Logger.getRootLogger().removeAppender(appenderMock);
    }
    
	@Test
	public void shouldReturnDefalultQuantityOfTeaWhenTeaIsOrder()
	{
		when(containerMaterialDTO.getTeaQuantity()).thenReturn(0);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Tea",containerMaterialDTO, 1,10);
		
		verify(containerMaterialDTO).getTeaQuantity();
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
	
	}
	
	@Test
	public void shouldReturnDefalultQuantityOfCoffeeWhenCoffeeIsOrder()
	{
		when(containerMaterialDTO.getCoffeeQuantity()).thenReturn(5);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee",containerMaterialDTO, 1,15);
		
		verify(containerMaterialDTO).getCoffeeQuantity();
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
		
	}
	
	@Test
	public void shouldReturnDefalultQuantityOfSugarWhenCoffeeorTeaIsOrder()
	{
		when(containerMaterialDTO.getSugarQuantity()).thenReturn(17);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Tea",containerMaterialDTO, 1,10);
		
		verify(containerMaterialDTO).getSugarQuantity();
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
		
	}
	
	@Test
	public void shouldReturnDefalultQuantityOfWaterWhenCoffeeorTeaIsOrder()
	{
		when(containerMaterialDTO.getWaterQuantity()).thenReturn(23);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee",containerMaterialDTO, 1,15);
		
		verify(containerMaterialDTO).getWaterQuantity();
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
	
	}
	
	@Test
	public void shouldReturnDefalultQuantityOfMilkWhenCoffeeorTeaIsOrder()
	{
		when(containerMaterialDTO.getMilkQuantity()).thenReturn(88);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Tea",containerMaterialDTO, 1,10);
		
		verify(containerMaterialDTO).getMilkQuantity();
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
	
	}
	
	@Test
	public void shouldNotMakeDrinkWhenContainerHavingInSufficientQuantityOfMaterial(){
		
		when(containerMaterialDTO.getTeaQuantity()).thenReturn(0);
		when(containerMaterialDTO.getCoffeeQuantity()).thenReturn(5);
		when(containerMaterialDTO.getSugarQuantity()).thenReturn(17);
		when(containerMaterialDTO.getWaterQuantity()).thenReturn(23);
		when(containerMaterialDTO.getMilkQuantity()).thenReturn(88);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee",containerMaterialDTO, 1000,15);
		
		verify(appenderMock,times(4)).doAppend((LoggingEvent) anyObject());
				
	}
	
	@Test
	public void shouldMakeDrinkWhenContainerHavingSufficientQuantityOfMaterial(){
		
		when(containerMaterialDTO.getTeaQuantity()).thenReturn(0);
		when(containerMaterialDTO.getCoffeeQuantity()).thenReturn(5);
		when(containerMaterialDTO.getSugarQuantity()).thenReturn(17);
		when(containerMaterialDTO.getWaterQuantity()).thenReturn(23);
		when(containerMaterialDTO.getMilkQuantity()).thenReturn(88);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee",containerMaterialDTO, 10,15);
		
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
				
	}
	
	@Test
	public void shouldSetMaxCapacityOfTeaConatinerAndKeyWhenUserProvideChoiceOne()
	{
		when(scanner.nextInt()).thenReturn(1,1,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldSetMaxCapacityOfTeaConatinerAndKeyWhenUserProvideChoiceTwo()
	{
		when(scanner.nextInt()).thenReturn(2,1,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldSetMaxCapacityOfTeaConatinerAndKeyWhenUserProvideChoiceThree()
	{
		when(scanner.nextInt()).thenReturn(3,1,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldSetMaxCapacityOfTeaConatinerAndKeyWhenUserProvideChoiceFour()
	{
		when(scanner.nextInt()).thenReturn(4,1,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}

	@Test
	public void shouldSetMaxCapacityOfTeaConatinerAndKeyWhenUserProvideChoiceFive()
	{
		when(scanner.nextInt()).thenReturn(5,1,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldDisplayMenuAgainWhenUserProvideInvalidChoice()
	{
		when(scanner.nextInt()).thenReturn(7,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(2)).nextInt();
		verify(appenderMock,times(8)).doAppend((LoggingEvent) anyObject());
	}

	@Test
	public void shouldNotProceedForRefillingWhenMaxCapacityOfContainerIsNull()
	{
		when(scanner.nextInt()).thenReturn(9,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(2)).nextInt();
		verify(appenderMock,times(8)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldProceedForRefillingWhenMaxCapacityOfContainerIsNotNull()
	{
		when(scanner.nextInt()).thenReturn(1,0,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void sholdRefillContainerWhenMaterialIsWithinContainerCapacity()
	{
		ContainerMaterialDTO containerMaterialDTO = new ContainerMaterialDTO(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		
		when(scanner.nextInt()).thenReturn(2,10,0);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee",containerMaterialDTO, 10, 15);
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(appenderMock,times(10)).doAppend((LoggingEvent) anyObject());
		verify(scanner,times(3)).nextInt();
	}
	
	@Test
	public void sholdNotRefillContainerWhenMaterialIsExtraThanContainerCapacity()
	{
		when(scanner.nextInt()).thenReturn(1,100,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(3)).nextInt();
		verify(appenderMock,times(9)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldReturnTrueWhenUserEnterChoiceOne()
	{
		when(scanner.nextInt()).thenReturn(7,1,0);
		
		teaCoffeeVendingMachineOperationImpl.refillContainer(true);
		
		verify(scanner,times(4)).nextInt();
		verify(appenderMock,times(16)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldDisplayTotalSaleReport()
	{
		ContainerMaterialDTO containerMaterialDTO = new ContainerMaterialDTO(0, 4, 15, 20, 80, 0, 1, 2, 3, 8);
		containerMaterialDTO.setNumberOfCups(2);
		containerMaterialDTO.setPriceOfDrink(10);
		
		teaCoffeeVendingMachineOperationImpl.makeDrink("Tea", containerMaterialDTO, 10, 10);
		teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee", containerMaterialDTO, 10, 10);
		
		teaCoffeeVendingMachineOperationImpl.totalSaleCalculator();
		
		verify(appenderMock,times(18)).doAppend((LoggingEvent) anyObject());
		
	}

	@Test
	public void shouldDisplayContainerStatus()
	{
		teaCoffeeVendingMachineOperationImpl.containerStatus();
		
		verify(appenderMock,times(12)).doAppend((LoggingEvent) anyObject());
		
	}
	
	@Test
	public void shouldResetContainerToItsDefaultCapacity()
	{
		teaCoffeeVendingMachineOperationImpl.resetContainer();
		
		verify(appenderMock,times(1)).doAppend((LoggingEvent) anyObject());
		
	}

}
