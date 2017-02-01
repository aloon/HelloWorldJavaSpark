import Services.HelloServiceImp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloService {

  @Test
  public void Hello() {
    Services.HelloService hello = new HelloServiceImp();
    String result = hello.hello();

    assertEquals(result, "Hello");
  }

}
