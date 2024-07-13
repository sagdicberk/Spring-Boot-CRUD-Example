package Task4.UserOperations.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service // Sürekli nesne üretmemesi için kullanılır. bi tane üretsin hep onu kullansın
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
	private ModelMapper modelMapper;

	@Override
	public ModelMapper forResponse() {
		
		//Gevşek bağlı bir mapper
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		
		//Normal bağlı bir mapper
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}

}
