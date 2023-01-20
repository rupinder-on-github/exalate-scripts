import com.exalate.api.sync.SyncService
import com.exalate.api.sync.SyncContext
import com.exalate.api.sync.SyncNode

def syncService = componentManager.getComponent(SyncService)
def syncContext = new SyncContext()

// Define the label that the epic should have to be synced
def label = "epic label"

// Get all epics with the defined label
def epics = issueManager.getIssuesByJqlSearch("issueType = Epic AND labels = " + label, null )

// Add the epics to the sync context
epics.each {
    def syncNode = new SyncNode(it)
    syncNode.addField("Summary")
    syncNode.addField("Issue Type")
    syncNode.addField("Description")
    syncNode.addField("Reporter")    
    syncNode.addField("Client Facing")
    syncNode.addField("Priority")
    syncNode.addField("Fix Version")
    syncNode.addField("Labels")
    syncNode.addField("Security Level")
    syncNode.addField("Linked Issues")
    syncNode.addField("Assignee")
    syncNode.addField("Epic Link")
    syncNode.addField("Business Testing Area")
    syncNode.addField("BR number")
    syncNode.addField("Owner")
    syncNode.addField("Sprint")   
    syncNode.addField("Requirement")
    syncNode.addField("Acceptance Criteria")
}

// Perform the sync
syncService.sync(syncContext)
