package aufgabenblatt3;

import javafx.application.Platform;
import javafx.concurrent.Task;

public class SimulationTask  extends Task<Boolean>{

	private final Simulation simulation;
	public SimulationTask(Simulation simul) {
		simulation = simul;
	}
	@Override
	protected Boolean call() throws Exception {
		Platform.runLater(simulation);
		return true;
	}

}
