if(NOT TARGET libgcg)
  include("${CMAKE_CURRENT_LIST_DIR}/gcg-targets.cmake")
endif()

if(0)
   set(SCIP_DIR "/nfs/OPTI/jenkins/workspace/SCIPOptSuite_linux_release/scipoptsuite-6.0.2/build-opt-gnu")
   find_package(SCIP QUIET CONFIG)
endif()

set(GCG_LIBRARIES libgcg)
set(GCG_INCLUDE_DIRS "${CMAKE_CURRENT_LIST_DIR}/../../../include")
set(GCG_FOUND TRUE)
