import processes.Result;

public class Main {

    public static void main(String[] args) {
		String calculated = "2+345-(7*2)";
		System.out.println("Выражение: " + calculated);
		Result result = new Result();
		System.out.println("Результат: " + result.result(calculated));
    }
}
