package Task4.UserOperations.core.utilities.mappers;

import org.modelmapper.ModelMapper;

// strateji oluştumak için lazım 
// requestten gelenleri mapping yapabiliriz
public interface ModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();
	
}
