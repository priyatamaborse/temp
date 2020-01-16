package assignment.com.yash.training;


import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

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
public class TeaCoffeeVendingMachineSimulatorTest {
	
	@InjectMocks
	private TeaCoffeeVendingMachineSimulator teaCoffeeVendingMachineSimulator;
	
	@Mock
	private MyScanner myScanner;
	
	@Mock
	private TeaCoffeeVendingMachineOperationImpl teaCoffeeVendingMachineOperationImpl;
	
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
	public void shouldPerformMakeDrinkOperationWhenCaseOneAndFiveCupsProvided()
	{
		 when(myScanner.nextInt()).thenReturn(1,5,0);
		 doNothing().when(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		  
		 teaCoffeeVendingMachineSimulator.menuList();
		 
		 verify(myScanner,times(3)).nextInt();
		 verify(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 verify(appenderMock,times(21)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldPerformMakeDrinkOperationWhenCaseTwoAndThreeCupsProvided()
	{
		 when(myScanner.nextInt()).thenReturn(2,3,0);
		 doNothing().when(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 
		 teaCoffeeVendingMachineSimulator.menuList();
		 
		 verify(myScanner,times(3)).nextInt();
		 verify(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 verify(appenderMock,times(21)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldPerformMakeDrinkOperationWhenCaseThreeAndOneCupProvided()
	{
		 when(myScanner.nextInt()).thenReturn(3,1,0);
		 doNothing().when(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 
		 teaCoffeeVendingMachineSimulator.menuList();
		 
		 verify(myScanner,times(3)).nextInt();
		 verify(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 verify(appenderMock,times(21)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldPerformMakeDrinkOperationWhenCaseFourAndOneCupProvided()
	{
		 when(myScanner.nextInt()).thenReturn(4,1,0);
		 doNothing().when(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 
		 teaCoffeeVendingMachineSimulator.menuList();
		
		 verify(myScanner,times(3)).nextInt();
		 verify(teaCoffeeVendingMachineOperationImpl).makeDrink(anyString(),any(ContainerMaterialDTO.class), anyInt(),anyInt());
		 verify(appenderMock,times(21)).doAppend((LoggingEvent) anyObject());
	}

	@Test
	public void shouldPerformRefillContainerOperationWhenCaseFiveProvided()
	{
		 when(myScanner.nextInt()).thenReturn(5,0);
		 doNothing().when(teaCoffeeVendingMachineOperationImpl).refillContainer(true);
		 
		 teaCoffeeVendingMachineSimulator.menuList();
		 
		 verify(myScanner,times(2)).nextInt();
		 verify(teaCoffeeVendingMachineOperationImpl).refillContainer(true);
		 verify(appenderMock,times(20)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldPerformTotalSaleCalculatorOperationWhenCaseSixProvided()
	{
		when(myScanner.nextInt()).thenReturn(6,0);
		doNothing().when(teaCoffeeVendingMachineOperationImpl).totalSaleCalculator();
		
		teaCoffeeVendingMachineSimulator.menuList();
	 
		verify(myScanner,times(2)).nextInt();
		verify(teaCoffeeVendingMachineOperationImpl).totalSaleCalculator();
		verify(appenderMock,times(20)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldPerformContainerStatusOperationWhenCaseSevenProvided()
	{
		when(myScanner.nextInt()).thenReturn(7,0);
		doNothing().when(teaCoffeeVendingMachineOperationImpl).containerStatus();
		
		teaCoffeeVendingMachineSimulator.menuList();
		
		verify(myScanner,times(2)).nextInt();
		verify(teaCoffeeVendingMachineOperationImpl).containerStatus();
		verify(appenderMock,times(20)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldPerformResetContainerOperationWhenCaseEightProvided()
	{
		when(myScanner.nextInt()).thenReturn(8,0);
		doNothing().when(teaCoffeeVendingMachineOperationImpl).resetContainer();
		
		teaCoffeeVendingMachineSimulator.menuList();
		
		verify(myScanner,times(2)).nextInt();
		verify(teaCoffeeVendingMachineOperationImpl).resetContainer();
		verify(appenderMock,times(20)).doAppend((LoggingEvent) anyObject());
	}

	@Test
	public void shouldExitFromDoWhileWhenCaseZeroProvided()
	{
		 when(myScanner.nextInt()).thenReturn(0);
		 
		 teaCoffeeVendingMachineSimulator.menuList();
		 
		 verify(myScanner,times(1)).nextInt();
		 verify(appenderMock,times(10)).doAppend((LoggingEvent) anyObject());
	}
	
	@Test
	public void shouldDisplayMenuAgainWhenUserProvideInvalidChoice()
	{
		 when(myScanner.nextInt()).thenReturn(9,0);
		 
		 teaCoffeeVendingMachineSimulator.menuList();
		 
		 verify(myScanner,times(2)).nextInt();
		 verify(appenderMock,times(21)).doAppend((LoggingEvent) anyObject());
	}
	
}
