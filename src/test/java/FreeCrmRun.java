import com.bdd.base.BaseClass;

import cucumber.api.cli.Main;

public class FreeCrmRun extends BaseClass{

	public static void main(String[] args) throws Throwable {
		BaseClass.readMasterData();
		BaseClass.AppendApproveTagToFeature(System.getProperty("user.dir")+"/src/test/resources/Features1");
		
		Main.main(new String[]{"-g", "com.bdd.steps", "src/test/resources/Features1","-t","~@Ignore"});
	}
}
