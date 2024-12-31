package com.yoda.cbt.models

import androidx.compose.runtime.Composable
import composemp.composeapp.generated.resources.Res
import composemp.composeapp.generated.resources.anger
import composemp.composeapp.generated.resources.anger_description
import composemp.composeapp.generated.resources.anger_prompt
import composemp.composeapp.generated.resources.anger_title
import composemp.composeapp.generated.resources.break_up_description
import composemp.composeapp.generated.resources.break_up_prompt
import composemp.composeapp.generated.resources.break_up_title
import composemp.composeapp.generated.resources.breakup
import composemp.composeapp.generated.resources.fear_of_failure
import composemp.composeapp.generated.resources.fear_of_failure_description
import composemp.composeapp.generated.resources.fear_of_failure_prompt
import composemp.composeapp.generated.resources.fear_of_failure_title
import composemp.composeapp.generated.resources.feeling_low
import composemp.composeapp.generated.resources.feeling_low_description
import composemp.composeapp.generated.resources.feeling_low_prompt
import composemp.composeapp.generated.resources.feeling_low_title
import composemp.composeapp.generated.resources.loneliness
import composemp.composeapp.generated.resources.loneliness_description
import composemp.composeapp.generated.resources.loneliness_prompt
import composemp.composeapp.generated.resources.loneliness_title
import composemp.composeapp.generated.resources.ocd
import composemp.composeapp.generated.resources.ocd_description
import composemp.composeapp.generated.resources.ocd_prompt
import composemp.composeapp.generated.resources.ocd_title
import composemp.composeapp.generated.resources.relationship
import composemp.composeapp.generated.resources.relationship_description
import composemp.composeapp.generated.resources.relationship_prompt
import composemp.composeapp.generated.resources.relationship_title
import composemp.composeapp.generated.resources.stress
import composemp.composeapp.generated.resources.stress_description
import composemp.composeapp.generated.resources.stress_prompt
import composemp.composeapp.generated.resources.stress_title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource


data class PromptSelectionCard (
    val title: String,
    val description: String,
    val cardBg: DrawableResource,
    val prompt: String
)

@Composable
fun getPromptDetails(): List<PromptSelectionCard> {
    return listOf(
        PromptSelectionCard(
            title = stringResource(Res.string.break_up_title),
            description = stringResource(Res.string.break_up_description),
            cardBg = Res.drawable.breakup,
            prompt = stringResource(Res.string.break_up_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.relationship_title),
            description = stringResource(Res.string.relationship_description),
            cardBg = Res.drawable.relationship,
            prompt = stringResource(Res.string.relationship_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.loneliness_title),
            description = stringResource(Res.string.loneliness_description),
            cardBg = Res.drawable.loneliness,
            prompt = stringResource(Res.string.loneliness_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.feeling_low_title),
            description = stringResource(Res.string.feeling_low_description),
            cardBg = Res.drawable.feeling_low,
            prompt = stringResource(Res.string.feeling_low_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.fear_of_failure_title),
            description = stringResource(Res.string.fear_of_failure_description),
            cardBg = Res.drawable.fear_of_failure,
            prompt = stringResource(Res.string.fear_of_failure_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.ocd_title),
            description = stringResource(Res.string.ocd_description),
            cardBg = Res.drawable.ocd,
            prompt = stringResource(Res.string.ocd_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.anger_title),
            description = stringResource(Res.string.anger_description),
            cardBg = Res.drawable.anger,
            prompt = stringResource(Res.string.anger_prompt)
        ),
        PromptSelectionCard(
            title = stringResource(Res.string.stress_title),
            description = stringResource(Res.string.stress_description),
            cardBg = Res.drawable.stress,
            prompt = stringResource(Res.string.stress_prompt)
        )
    )
}
