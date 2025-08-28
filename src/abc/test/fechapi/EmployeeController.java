package abc.test.fechapi;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/getUsers/{id}")
	public RestTemplate<List<Ticket>> getData(@PathVariable Long id) {
		return RestTemplate.ok(empService.getTicketsByUserId(id));
	}
	

}
