package at.szyon.basicbenchmark;

import at.szyon.basicutils.BasicUtil;
import at.szyon.basicutils.BasicVersion;

public class BasicBenchmark {
    public static final BasicUtil INFO = BasicUtil.build()
            .setAuthors("Szyon")
            .setVersion(BasicVersion.build()
                    .setMajor(1)
                    .setMinor(1)
                    .setMonth(8)
                    .setYear(22)
                    .setBuildState(BasicVersion.BuildState.RELEASE)
            );
}
