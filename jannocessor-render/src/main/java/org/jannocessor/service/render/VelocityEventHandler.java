package org.jannocessor.service.render;

import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.app.event.InvalidReferenceEventHandler;
import org.apache.velocity.app.event.MethodExceptionEventHandler;
import org.apache.velocity.app.event.NullSetEventHandler;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.context.Context;
import org.apache.velocity.util.introspection.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityEventHandler implements ReferenceInsertionEventHandler,
		NullSetEventHandler, MethodExceptionEventHandler,
		InvalidReferenceEventHandler {

	private Logger logger = LoggerFactory.getLogger("VELOCITY EVENT");

	public void listenToContext(Context ctx) {
		EventCartridge ec = new EventCartridge();
		ec.addEventHandler(this);
		ec.attachToContext(ctx);
	}

	public Object referenceInsert(String reference, Object data) {
		return data;
	}

	public boolean shouldLogOnNullSet(String lhs, String rhs) {
		return true;
	}

	@SuppressWarnings("rawtypes")
	public Object methodException(Class cls, String method, Exception e)
			throws Exception {
		return "An " + e.getClass().getName() + " was thrown by the " + method
				+ " method of the '" + cls.getName() + "' class ["
				+ e.getMessage() + "]";
	}

	@Override
	public Object invalidGetMethod(Context context, String reference,
			Object object, String property, Info info) {
		return null;
	}

	@Override
	public boolean invalidSetMethod(Context context, String leftreference,
			String rightreference, Info info) {
		logger.error("Invalid write: {left:{}, right:{}, template:{}}",
				new Object[] { leftreference, rightreference, info });
		return false;
	}

	@Override
	public Object invalidMethod(Context context, String reference,
			Object object, String method, Info info) {
		logger.error(
				"Invalid method: {ref:{}, obj:{}, method:{}, template:{}}",
				new Object[] { reference, object, method, info });
		return null;
	}

}
