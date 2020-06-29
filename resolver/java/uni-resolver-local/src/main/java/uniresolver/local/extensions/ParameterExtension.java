package uniresolver.local.extensions;

public interface ParameterExtension extends Extension {

	String[] handlesParameters();

	abstract class AbstractParameterExtension extends AbstractExtension implements ParameterExtension {

		@Override
		public String[] handlesParameters() {

			return new String[0];
		}
	}
}
