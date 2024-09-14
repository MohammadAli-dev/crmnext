class CustomerViewModel(private val useCase: CustomerUseCase) : ViewModel() {
    private val _customers = MutableLiveData<List<Customer>>()
    val customers: LiveData<List<Customer>> = _customers

    fun getCustomers() {
        viewModelScope.launch {
            val customers = useCase.getCustomers()
            _customers.value = customers
        }
    }

    fun saveCustomer(customer: Customer) {
        viewModelScope.launch {
            useCase.saveCustomer(customer)
        }
    }
}
