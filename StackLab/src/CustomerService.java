public class CustomerService {

    private Queue<String> names;

    public CustomerService() {
        names = new Queue<String>();
    }

    public void addCustomer(String name) {
        names.add(name);
    }

    public String serveCustomer() {
        if (!names.isEmpty()) {
            return names.remove();
        }

        return null;
    }

    public String emptyQueue() {
        StringBuilder ret = new StringBuilder();
        if (!names.isEmpty()) {
            ret.append(names.remove());
        }

        while (!names.isEmpty()) {
            ret.append(",").append(" ").append(names.remove());
        }

        return ret.toString();
    }
}
