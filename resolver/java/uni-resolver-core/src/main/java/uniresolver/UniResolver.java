package uniresolver;

import java.util.Map;

import uniresolver.result.ResolveResult;

public interface UniResolver {

	String PROPERTIES_MIME_TYPE = "application/json";

	ResolveResult resolve(String identifier) throws ResolutionException;
	ResolveResult resolve(String identifier, Map<String, String> options) throws ResolutionException;
	Map<String, Map<String, Object>> properties() throws ResolutionException;
}
