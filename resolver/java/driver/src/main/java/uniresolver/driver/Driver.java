package uniresolver.driver;

import java.util.Map;

import uniresolver.ResolutionException;
import uniresolver.result.ResolveResult;

public interface Driver {

	String PROPERTIES_MIME_TYPE = "application/json";

	ResolveResult resolve(String identifier) throws ResolutionException;
	Map<String, Object> properties() throws ResolutionException;
}
