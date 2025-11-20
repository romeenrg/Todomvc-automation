public interface TodoMVCInterface {
    void navigate();
    void addTodo(String item);
    void createList();
    void clickDownArrow();
    void complete(Integer num);
    void incomplete(Integer num);
    String specifyItemsLeft();
    String getTodoCount(Integer itemCount);
    // Add any other common methods needed by the tests
}