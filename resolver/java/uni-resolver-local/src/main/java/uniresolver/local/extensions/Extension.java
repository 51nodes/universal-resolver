package uniresolver.local.extensions;

import java.util.Map;

import did.DIDURL;
import uniresolver.ResolutionException;
import uniresolver.local.LocalUniResolver;
import uniresolver.result.ResolveResult;

public interface Extension {

	ExtensionStatus beforeResolve(String identifier, DIDURL didUrl, Map<String, String> options, ResolveResult resolveResult,
								  LocalUniResolver localUniResolver) throws ResolutionException;
	ExtensionStatus afterResolve(String identifier, DIDURL didUrl, Map<String, String> options, ResolveResult resolveResult,
								 LocalUniResolver localUniResolver) throws ResolutionException;

	abstract class AbstractExtension implements Extension {

		@Override
		public ExtensionStatus beforeResolve(String identifier, DIDURL didUrl, Map<String, String> options, ResolveResult resolveResult, LocalUniResolver localUniResolver) throws ResolutionException {

			return null;
		}

		@Override
		public ExtensionStatus afterResolve(String identifier, DIDURL didUrl, Map<String, String> options, ResolveResult resolveResult, LocalUniResolver localUniResolver) throws ResolutionException {

			return null;
		}
	}
}
