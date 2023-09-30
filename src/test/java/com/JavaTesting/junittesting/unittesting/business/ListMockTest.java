package com.JavaTesting.junittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {
	List mock=Mockito.mock(List.class);

	@Test
	public void size_basic()
	{
//		List mock=Mockito.mock(List.class);
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	public void returnDifferentValues()
	{
//		List mock=Mockito.mock(List.class);
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
//		assertEquals(10,mock.size());
	}
	
	@Test
	public void returnWithParameter() {

//		List mock=Mockito.mock(List.class);
		when(mock.get(0)).thenReturn("I am the best Java Developer");
		assertEquals("I m good Developer",mock.get(0));
		assertEquals(null,mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameter() {

//		List mock=Mockito.mock(List.class);
		when(mock.get(anyInt())).thenReturn("I am the best Java Developer");
		assertEquals("I m good Developer",mock.get(0));
//		assertEquals("I m good Developer",mock.get(1));
	}
	
	@Test
	public void VerificationBasics() {
		//SUT
		String value1= (String) mock.get(0);
		String value2= (String) mock.get(1);
		
		//Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("Shiva is best Java Developer");
		
		//Verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class); 
		verify(mock).add(captor.capture());
		
		assertEquals("Shiva the best Java Developer",captor.getValue());
	}
	
	@Test
	public void MultipleargumentCapturing() {
		//SUT
		mock.add("Shiva is best Java Developer");
		mock.add("i am the best Java Developer");
		
		//Verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class); 
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues=captor.getAllValues();
		assertEquals("Shiva the best Java Developer",allValues.get(0));
		assertEquals("i am  the best Java Developer",allValues.get(1));
	}
	
	
	@Test
	public void Spying() {
		ArrayList arrayListMock=mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));
		System.out.println(arrayListMock.size());
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock=mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//o
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);//5
		
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy=mock(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//nul
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		when(arrayListSpy.size()).thenReturn(5);//5
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//4
		verify(arrayListSpy).add("Test5");
		
	}
	
	
	
}
