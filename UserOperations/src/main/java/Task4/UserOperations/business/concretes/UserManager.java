package Task4.UserOperations.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Task4.UserOperations.business.abstracts.UserService;
import Task4.UserOperations.business.requests.CreateUserRequest;
import Task4.UserOperations.business.requests.UpdateUserRequest;
import Task4.UserOperations.business.responses.GetAllUserResponse;
import Task4.UserOperations.business.responses.GetByIdUserResponse;
import Task4.UserOperations.core.utilities.mappers.ModelMapperService;
import Task4.UserOperations.dataAccess.abstracts.UserRepo;
import Task4.UserOperations.entities.concretes.Users;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // constructor oluşturmak için bütün argümanlarla
public class UserManager implements UserService {
	private UserRepo userRepo;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllUserResponse> getAll() {
		// DATABASE'den gelen veri
		List<Users> users = userRepo.findAll();

		// RETURN edilecek değer
//		List<GetAllUserResponse> usersResponses = new ArrayList<GetAllUserResponse>();

//		for (Users user : users) {
//			GetAllUserResponse responseItem = new GetAllUserResponse();
//			responseItem.setId(user.getId());
//			responseItem.setName(user.getName());
//			responseItem.setEmail(user.getEmail());
//			
//
//			
//			usersResponses.add(responseItem);
//		}

		// model mapper kullanımı
		List<GetAllUserResponse> usersResponses = users.stream()
				.map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class))
				.collect(Collectors.toList());
		// Kurallar

		return usersResponses;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {
		// veritabanına kayıt ekleme
//		Users user = new Users(); // yeni bi user oluştur
//		user.setName(createUserRequest.getName()); // ismini createUserRequest'dan alsın
//		user.setEmail(createUserRequest.getEmail()); // mailini createUserRequest'dan alsın
//		this.userRepo.save(user);

		// Mapping ile yapılırsa
		Users user = this.modelMapperService.forRequest().map(createUserRequest, Users.class);
		this.userRepo.save(user);
	}

	@Override
	public void delete(int id) {
		// id ile silme işlemi yapmak için
		userRepo.deleteById(id);

	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		// id ile güncelleme yapmak için

		Users user = this.modelMapperService.forRequest().map(updateUserRequest, Users.class);
		this.userRepo.save(user);
		
//		Users user = userRepo.findById(updateUserRequest.getId()).orElseThrow();
//		if (optionalUser.isPresent()) {
//			Users user = optionalUser.get();
//			user.setEmail(updateUserRequest.getEmail());
//			user.setName(updateUserRequest.getName());
//			this.userRepo.save(user);
//		} else {
//			throw new RuntimeException(updateUserRequest.getId() + "'ye sahip bir kullanıcı bulunamadı");
//		}

		// model mapping kullanılan alan
//		if (optionalUser.isPresent()) {
//			Users user = this.modelMapperService.forRequest().map(updateUserRequest, Users.class);
//			this.userRepo.save(user);
//		} else {
//			throw new RuntimeException(updateUserRequest.getId() + "'ye sahip bir kullanıcı bulunamadı");
//		}
		
		
	}

	@Override
	public GetByIdUserResponse getById(int id) {
		// id ile bulma işlemi
		Users user = this.userRepo.findById(id).orElseThrow(); // verilen id'ye sahip kullanıcıyı bul
		GetByIdUserResponse response = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class); // modelmapper ile istenen sınıf türüne cevir ve response değeri oluştur
		return response; // response return et
	}

}
