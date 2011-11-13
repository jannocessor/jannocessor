package example.service;

import org.jannocessor.common.annotation.GenerateFacade;

@GenerateFacade
public interface MultiplicationService {

	int multiply(int x, int y);

	void doNothing();

}
