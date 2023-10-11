public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("товар с id: " + id + " уже существует");
    }
}
