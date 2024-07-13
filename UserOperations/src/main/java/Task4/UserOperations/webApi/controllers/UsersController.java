package Task4.UserOperations.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Task4.UserOperations.business.abstracts.UserService;
import Task4.UserOperations.business.requests.CreateUserRequest;
import Task4.UserOperations.business.requests.UpdateUserRequest;
import Task4.UserOperations.business.responses.GetAllUserResponse;
import Task4.UserOperations.business.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;

@RestController // annotation //
@AllArgsConstructor
// bu sınıf isteklere uygun cevapları döndürür.
@RequestMapping("/api/users") // url ile işlem yapmak içindir. aşağıda bulunan uzantılar bu uzantının sonuna
								// eklenecektir.
public class UsersController {
	// UserService interfaceinden bir servis oluşturur.
	private UserService userService;

	// @allarg notasyonu ile ihtiyaç kalmadı
//	@Autowired // bu notasyon sayesinde  bağımlılık enjeksiyonu ile bu sınıfa enjekte edilmesini sağlar.
//	public UsersController(UserService userService) {
//		this.userService = userService;
//	}

	// Get isteği bu url uzantsına atılırsa getall fonksiyonun çalışmasını sağlar.
	@GetMapping()
	public List<GetAllUserResponse> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdUserResponse getById(@PathVariable int id) {
		return userService.getById(id);
	}

	// Post isteği bu url uzantsına atılırsa Kullanıcı ekleme fonksiyonun
	// çalışmasını sağlar.
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED) // 201 Kodu döndürmesi için {Oluşturuldu}
	public void add(@RequestBody CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}

	// Delete isteği bu url uzantsına atılırsa id'si verilen kullanıcıyı silme
	// fonksiyonun çalışmasını sağlar. (Soft delete araştırması yap aktif, pasif)
	@DeleteMapping("/{id}") // patte bulunan değişken delete metodu ile gelirse 
	public void delete(@PathVariable int id) { // id değerini path üzerinden al
		this.userService.delete(id);
	}

	// Put isteği bu url uzantısına atılırsa id'si bilinen kullanıcının diğer
	// bilgileri değiştirilebilir.
	@PutMapping("/update")
	public void update(@RequestBody UpdateUserRequest updateUserRequest) { //Request bodysinden al demek /yazmasanda çalışyor denedim
		this.userService.update(updateUserRequest);
	}
}
