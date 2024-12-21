package service.codegym;

import database.emaillapp.Users;
import java.util.List;
import model.emailapp.Customer;

public class CustomerService {

    private Users customerDao;

    public CustomerService() {
        customerDao = new Users();
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public void deleteCustomer(String username) {  // Changed parameter type to String
        customerDao.deleteCustomer(username);     // Changed parameter to username
    }

    public Customer getCustomerByUsername(String username) {  // Changed method name and parameter to username
        return customerDao.getCustomerByUsername(username);   // Changed method to use username
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
    
    public List<Customer> searchCustomers(String valToSearch) {
        return customerDao.searchCustomers(valToSearch);
    }
}
