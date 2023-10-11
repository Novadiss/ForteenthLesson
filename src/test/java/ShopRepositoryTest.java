import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Игрушка", 100);
    Product product2 = new Product(22, "Фильм", 2_000);
    Product product3 = new Product(333, "Инструмент", 30_000);
    Product product4 = new Product(4_444, "Техника", 400_000);

    @Test
    public void removeProductWhenExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(333);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductWhenNotExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(321)
        );
    }

    @Test
    public void addingProductWhenNotExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3,};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addingProductWhenExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(AlreadyExistsException.class,
                () -> {
                    repo.add(product1);
                }
        );
    }
}
