import somma.ProjectPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    projectPasswordEncoderListener(ProjectPasswordEncoderListener, ref('hibernateDatastore'))
}
