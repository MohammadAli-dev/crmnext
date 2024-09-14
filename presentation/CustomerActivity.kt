class CustomerActivity : AppCompatActivity() {
    private lateinit var viewModel: CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        viewModel = ViewModelProvider(this).get(CustomerViewModel::class.java)

        viewModel.customers.observe(this, Observer { customers ->
            // Update UI with customers
        })

        // Call getCustomers() to load data
        viewModel.getCustomers()
    }
}