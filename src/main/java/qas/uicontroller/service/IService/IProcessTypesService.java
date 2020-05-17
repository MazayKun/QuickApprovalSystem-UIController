package qas.uicontroller.service.IService;


import qas.uicontroller.model.ProcessType;
import qas.uicontroller.service.ProcessStageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IProcessTypesService {

    List<ProcessType> allProcessTypes(HttpServletRequest request) throws Exception;
    ProcessType getProcessTypeById(HttpServletRequest request, int id) throws Exception;
    List<ProcessType> getProcessTypesWithStagesOnly(HttpServletRequest request, ProcessStageService stageService)
        throws Exception;
}
