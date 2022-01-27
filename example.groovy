def example1() {
  println 'Hello from example1'
}

def example2() {
  println 'Hello from example2'
}
def getSuccessfulBuild() {
def builds = []
def JOBNAME = "test"
def job = jenkins.model.Jenkins.instance.getItem(JOBNAME)
job.builds.each {
    if (it.result == hudson.model.Result.SUCCESS) {
        builds.add(it.displayName[1..-1])
    }
}
println builds
return builds
}
return this
