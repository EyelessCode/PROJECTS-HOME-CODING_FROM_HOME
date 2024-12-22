import repository.CalculateSalaryRepository;

public class App {
    public static void main(String[] args) throws Exception {
        CalculateSalaryRepository calculateRepository=new CalculateSalaryRepository();
        System.out.println("Hello, World!");
        System.out.printf("R: %.2f - A: %.2f - S: %.2f", calculateRepository.repositoryWorker(),
        calculateRepository.atmWorker(),calculateRepository.supervisorWorker());
    }
}
