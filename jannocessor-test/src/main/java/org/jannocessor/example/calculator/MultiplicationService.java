package org.jannocessor.example.calculator;

import org.jannocessor.extra.annotation.GenerateFacade;

@GenerateFacade
public interface MultiplicationService {

	int multiply(int x, int y);

	void doNothing();

}
