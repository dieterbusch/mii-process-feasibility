package de.medizininformatik_initiative.process.feasibility.service;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.hl7.fhir.r4.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AggregateMeasureReports extends AbstractServiceDelegate {
    private static final Logger logger = LoggerFactory.getLogger(AggregateMeasureReports.class);

    public AggregateMeasureReports(ProcessPluginApi api) {
        super(api);
    }

    @Override
    protected void doExecute(DelegateExecution delegateExecution, Variables variables) throws Exception {
        logger.info("doExecute store and aggregate measure reports");

        // Die Reports rausholen. Ggf. die Tasks aus StoreLiveResult holen.
        List<Task.TaskOutputComponent> output = variables.getLatestTask().getOutput();
      //  Resource r = (Resource) output.get(0).getValue();
/*

- Speichen und zurordnen der empfangenen Ergebnisse.
Hi, Hauke hat ein Beispiel im dsf-process-ping-pong:

Dort wird in den einzelnen Sub-Prozessen eine Variable angelegt,
die den correlationKey im Namen enthält, der bei der Erstellung der targets für
jedes einzelne target angelegt wird. Die Variablennamen der einzelnen Subprozesse
werden dann in dem Aggregations-Service wieder anhand der targets generiert und damit
die einzelnen Werte geholt.
 */
        // aus
        List<HistoricActivityInstance> list = delegateExecution.getProcessEngine().getHistoryService()
                .createHistoricActivityInstanceQuery().activityId("Activity_08pv42f").list();
        HistoricActivityInstance i = list.get(0);

        logger.info(i.toString());

    }
}