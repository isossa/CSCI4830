
public aspect TraceAspectSossa
{
	pointcut classToTrace(): within( *App );
	pointcut methodToTrace(): classToTrace() && execution( String getName() );
	
	before(): methodToTrace()
	{
		System.out.printf("[BGN] %s, %s\n", thisJoinPointStaticPart.getSignature(),
				thisJoinPointStaticPart.getSourceLocation().getLine());
	}
	
	after(): methodToTrace()
	{
		System.out.printf("[END] %s\n", thisJoinPointStaticPart.getSourceLocation().getFileName());
	}
}
