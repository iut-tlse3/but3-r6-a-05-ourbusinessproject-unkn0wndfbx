package ourbusinessproject;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping is used to map the request URL to the method
@RequestMapping("/api/v1/partnerships")
public class PartnershipController {
    private EnterpriseProjectService enterpriseProjectService;
    private PartnershipService partnershipService;

    public PartnershipController(EnterpriseProjectService enterpriseProjectService, PartnershipService partnershipService) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    // @GetMapping is used to map the GET request to the method
    @GetMapping
    public List<Project> findAllProjectsWithEnterprises() {
        return enterpriseProjectService.findAllProjects();
    }

    @PostMapping
    public Partnership addPartnership(@RequestParam("project_id") long projectId,
            @RequestParam("enterprise_id") long enterpriseId) {
        Project project = this.enterpriseProjectService.findProjectById(projectId);
        Enterprise enterprise = this.enterpriseProjectService.findEnterpriseById(enterpriseId);
        return this.partnershipService.newPartnership(project, enterprise);
    }

    @DeleteMapping("/{id}")
    public void removePartnership(@PathVariable("id") long partnershipId) {
        Partnership partnership = this.partnershipService.findPartnershipById(partnershipId);
        this.partnershipService.remove(partnership);
    }
}