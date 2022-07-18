package com.wednesday.core_common.base.datetime

import com.wednesday.core_model.date.Date
import com.wednesday.core_common.base.BaseUnsafeUseCase

interface FormatDateUseCase : BaseUnsafeUseCase<Pair<Date, String>, String>
