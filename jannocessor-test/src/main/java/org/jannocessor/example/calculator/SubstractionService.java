package org.jannocessor.example.calculator;

import org.jannocessor.common.annotation.GenerateFacade;

@GenerateFacade
public interface SubstractionService {

	int substract(int a, int b);

}
