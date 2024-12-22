package controller;

import repository.ValidationRepository;
import view.WorkerView;

public class SalaryController {
    private ValidationRepository validationRepository=new ValidationRepository();
    private WorkerView workerView=new WorkerView();
    // private int input;
    
    public void validationWorker(){
        // lineString();
        workerView.pickWorker();
        validationRepository.validationPick();
        // return validationWorker();
    }


}
