package com.example.simpleplanner.DataClasses

import java.util.Date

data class Days(var date : Date,
                var tasks : List<Tasks> ?= null
                )
