package Guy;

import jade.Boot;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * Initialize agents
 */
public class InitAgent {

    public static Logger logger = Logger.getLogger("Main");
    public static int numAgents;
    public static String nameContainerOriginal;
    public static AgentContainer controllerAgentContainer;

    public InitAgent() {
        logger.trace("Start Method");
        numAgents = 0;
        nameContainerOriginal = "";
        controllerAgentContainer = null;
        logger.trace("Ended Method");
    }

    public InitAgent(Agent agent, String nameAgent, String nameContainer) throws StaleProxyException {
        logger.trace("Start Method");
        setAgentInContainer(agent, nameAgent, nameContainer);
        logger.trace("Ended Method");
    }

    private void setAgentInContainer(Agent agent, String nameAgent, String nameContainer) throws StaleProxyException {
        logger.trace("Start Method");
        Runtime runtime = Runtime.instance();
        if (!nameContainer.equals(nameContainerOriginal)) {
            nameContainerOriginal = nameContainer;
            Profile profile = new ProfileImpl();
            profile.setParameter(Profile.CONTAINER_NAME, nameContainer);
            controllerAgentContainer = runtime.createAgentContainer(profile);
        }
        AgentController controller;
        System.out.println("\n\n Name of agent: " + nameAgent);
        System.out.println("\n\n Agent: " + agent);
        controller = controllerAgentContainer.acceptNewAgent(nameAgent, agent);
        controller.start();
        logger.trace("Ended Method");
    }

    public static void init(Agent agent, String nameAgent, String nameContainer) throws StaleProxyException {
        logger.trace("Start Method");
        if (numAgents == 0) {
            Boot.main(new String[]{"-gui", "-jade_domain_df_maxresult", "500"});
        }
        numAgents++;
        new InitAgent(agent, nameAgent, nameContainer);
        logger.trace("Ended Method");
    }

}
