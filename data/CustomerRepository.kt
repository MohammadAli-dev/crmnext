interface CustomerRepository {
    suspend fun getCustomers(): List<Customer>
    suspend fun saveCustomer(customer: Customer)
}

class CustomerRepositoryImpl : CustomerRepository {
    private val customers = mutableListOf<Customer>()

    override suspend fun getCustomers(): List<Customer> {
        return customers
    }

    override suspend fun saveCustomer(customer: Customer) {
        customers.add(customer)
    }
}
