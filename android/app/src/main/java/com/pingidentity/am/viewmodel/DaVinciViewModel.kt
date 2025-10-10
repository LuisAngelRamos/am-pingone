package com.pingidentity.am.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pingidentity.orchestrate.ContinueNode
import com.pingidentity.davinci.DaVinci
import com.pingidentity.am.viewmodel.daVinci
import com.pingidentity.am.davinci.DaVinciState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * The view model for the DaVinci app. Holds the state of the app.
 */

class DaVinciViewModel : ViewModel() {
    var state = MutableStateFlow(DaVinciState())
        private set
    var loading = MutableStateFlow(false)
        private set

    /**
     * Initialize the DaVinci flow.
     */
    init {
        start()
    }

    /**
     * Call the next node in the DaVinci flow.
     *
     * @param current The current node.
     */
    fun next(current: ContinueNode) {
        loading.update {
            true
        }
        viewModelScope.launch {
            val next = current.next()
            loading.update {
                false
            }
        }
    }

    /**
     * Start the DaVinci flow.
     */
    fun start() {
        loading.update {
            true
        }
        viewModelScope.launch {
            val node = daVinci.start()
            loading.update {
                false
            }
        }
    }

    /**
     * Refresh the state of the DaVinci flow.
     */
    fun refresh() {
    }
}
