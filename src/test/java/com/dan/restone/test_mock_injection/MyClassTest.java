package com.dan.restone.test_mock_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MyClassTest {

    @Mock
    private DependencyOne dependencyOne;

    @Mock
    private DependencyTwo dependencyTwo;

    @InjectMocks
    private MyClass myClass;

    @Test
    void useDependencies(){
        //Given
        when(dependencyOne.doSomething()).thenReturn("Mocked DependencyOne");
        when(dependencyTwo.doSomethingElse()).thenReturn("Mocked DependencyTwo");

        //When
        String result = myClass.useDependencies();

        //Then
        Assertions.assertEquals("Mocked DependencyOne Mocked DependencyTwo", result);
    }
}
