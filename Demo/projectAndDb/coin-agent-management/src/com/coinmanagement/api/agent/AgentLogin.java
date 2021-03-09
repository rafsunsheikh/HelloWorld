package com.coinmanagement.api.agent;

import com.coinmanagement.bao.AgentBAO;
import com.coinmanagement.dto.agent.AgentAuthenticationDTO;
import com.coinmanagement.dto.agent.AgentResponseDTO;
import com.coinmanagement.utils.Messages;
import com.coinmanagement.utils.ReasonCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.ringid.webserver.HTTP;
import com.ringid.webserver.HTTPServer.Request;
import com.ringid.webserver.HTTPServer.Response;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author RingID Inc.
 */
public class AgentLogin extends HTTP {

    private static final Logger LOG = LogManager.getLogger(AgentLogin.class.getSimpleName());

    @Override
    public void doProcess(Request request, Response response) {

        AgentResponseDTO responseResult;

        try {
            String data = new String(request.getData());
            AgentAuthenticationDTO authDTO = new Gson().fromJson(data, AgentAuthenticationDTO.class);

            //get info from DB
            responseResult = AgentBAO.getInstance().getAgentInfoFromUserIdAndPassword(authDTO);
            response.print(new Gson().toJson(responseResult));

        } catch (JsonSyntaxException | IOException e) {
            LOG.error("Exception while reading input", e);
            responseResult = new AgentResponseDTO.Builder(false).mg(Messages.INVALID_INPUT_PARAMS).
                    rc(ReasonCode.EXCEPTION_OCCURED).build();
            response.print(new Gson().toJson(responseResult));
        }

    }
}
