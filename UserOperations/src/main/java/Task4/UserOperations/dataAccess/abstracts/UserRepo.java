package Task4.UserOperations.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Task4.UserOperations.entities.concretes.Users;


// UserRepo adında bir interface oluşturuyoruz.
// Bu interface JpaRepository interfacenin altsınıfı olduğunu belirtiyoruz
// extends ifadesi ile bağlıyoruz
// Users Entitiy için CRUD operasyonlarını gerçekleştirmek için yapılır.
// --------------------------------------------<Entitiy, ilk key id olduğu ve tipi integer olduğu için>
public interface UserRepo extends JpaRepository<Users, Integer> {
	
	

}
