class CustomerUseCase(private val repository: CustomerRepository) {
    suspend fun getCustomers(): List<Customer> {
        return repository.getCustomers()
    }

    suspend fun saveCustomer(customer: Customer) {
        repository.saveCustomer(customer)
    }
}