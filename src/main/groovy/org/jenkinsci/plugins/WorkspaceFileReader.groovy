package org.jenkinsci.plugins

import hudson.FilePath
import hudson.model.OneOffExecutor

/**
 * Created by jeremymarshall on 22/10/14.
 */
class WorkspaceFileReader {

    @Delegate FilePath scriptFile
    FilePath workspace

    WorkspaceFileReader() {
        OneOffExecutor thr = Thread.currentThread()
        this.workspace = thr.currentWorkspace
    }

    WorkspaceFileReader(String file) {
        this()
        File f = new File(file)

        if (f.isAbsolute()) {
            scriptFile = new FilePath(f)
        } else {
            scriptFile = workspace.child(file)
        }
    }
}
